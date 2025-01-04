import axios from "axios";
import React, { useState, useEffect } from "react";
import { Chart } from "react-google-charts";

export const options = {
  title: "Pestle Frequency",
  chartArea: { width: "50%" },
  isStacked: true,
  hAxis: {
    title: "Frequency",
  },
  vAxis: {
    title: "Pestle",
  },
};

export function BarChart() {
  const [BarchartData, setBarChartData] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get(
          "http://localhost:8080/pestle-frequency"
        );
        if (!response.data) {
          throw new Error("No data returned from server.");
        }
        const jsonData = response.data;
        const data = Object.entries(jsonData).map(([pestle, frequency]) => [
          pestle,
          frequency,
        ]);

        setBarChartData([["Pestle", "Frequency"], ...data]);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    }
    fetchData();
  }, []);

  return (
    <Chart
      chartType="BarChart"
      width="100%"
      height="400px"
      data={BarchartData}
      options={options}
    />
  );
}
