import React from "react";
import axios from "axios";
import { Chart } from "react-google-charts";
import { useState, useEffect } from "react";

export const options = {
  chart: {
    title: "City Wise Intensity and Relevence",
    subtitle: "City, Intensity, Relevence",
  },
};

export function Bar() {
  const [BarchartData, setBarChartData] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const response = await axios.get("http://localhost:8080/city");
        if (!response.data) {
          throw new Error("No data returned from server.");
        }
        const jsonData = response.data;
        const chartDataFormatted = jsonData.map((item) => [
          item.city,
          item.intensity,
          item.relevance,
        ]);

        setBarChartData([
          ["City", "Intensity", "Relivance"],
          ...chartDataFormatted,
        ]);
      } catch (error) {
        console.error("Error fetching data:", error);
      }
    }
    fetchData();
  }, []);

  return (
    <Chart
      chartType="Bar"
      width="100%"
      height="400px"
      data={BarchartData}
      options={options}
    />
  );
}
