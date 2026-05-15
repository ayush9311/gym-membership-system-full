document.addEventListener("DOMContentLoaded", function () {

    const totalMembers = document.getElementById("totalMembers");
    const activeMembers = document.getElementById("activeMembers");
    const totalPlans = document.getElementById("totalPlans");
    const totalSubscriptions = document.getElementById("totalSubscriptions");
    const estimatedRevenue = document.getElementById("estimatedRevenue");
    const chartCanvas = document.getElementById("subscriptionChart");

    fetch("/api/dashboard/stats")
        .then(response => response.json())
        .then(data => {

            function animateValue(element, start, end, duration) {
                let startTime = null;

                function step(timestamp) {
                    if (!startTime) startTime = timestamp;
                    let progress = Math.min((timestamp - startTime) / duration, 1);
                    element.innerText = Math.floor(progress * (end - start) + start);

                    if (progress < 1) requestAnimationFrame(step);
                }

                requestAnimationFrame(step);
            }

            if (totalMembers) animateValue(totalMembers, 0, data.totalMembers, 800);
            if (activeMembers) animateValue(activeMembers, 0, data.activeMembers, 800);
            if (totalPlans) animateValue(totalPlans, 0, data.totalPlans, 800);
            if (totalSubscriptions) animateValue(totalSubscriptions, 0, data.totalSubscriptions, 800);

            if (estimatedRevenue) {
                estimatedRevenue.innerText = "₹" + data.estimatedRevenue.toLocaleString();
            }

            if (chartCanvas) {
                const ctx = chartCanvas.getContext("2d");

                new Chart(ctx, {
                    type: "doughnut",
                    data: {
                        labels: ["Active", "Expired"],
                        datasets: [{
                            data: [data.activeSubscriptions, data.expiredSubscriptions],
                            backgroundColor: ["#22c55e", "#ef4444"],
                            hoverOffset: 10
                        }]
                    },
                    options: {
                        responsive: true,
                        cutout: "70%",
                        plugins: {
                            legend: {
                                position: "bottom"
                            }
                        }
                    }
                });
            }
        })
        .catch(error => console.log("API error:", error));
});