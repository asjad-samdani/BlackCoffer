import axios from "axios";
import React, { useEffect, useState } from "react";
import { Chart } from "react-google-charts";

export var options = {
  chart: {
    title: "Topic Likelihood",
    subtitle: "Topic Bases on Likelihood",
  },
  hAxis: { title: "Topic" },
  vAxis: { title: "Likelihood" },
};

export function Scatter() {
  const [ScatterData, setScatterData] = useState([]);

  useEffect(() => {
    async function fetchData() {
      try {
        const responce = await axios.get(`http://localhost:8080/topic`);
        if (!responce.data) {
          throw new Error("no data returned from surver");
        }
        const jsonData = responce.data;
        const data = Object.entries(jsonData).map(([topic, likelihood]) => [
          topic,
          likelihood,
        ]);
        setScatterData([["Topic", "Likelihood"], ...data]);
      } catch (error) {
        console.log("Error fetching ", error);
      }
    }
    fetchData();
  }, []);

  return (
    <Chart
      chartType="Scatter"
      width="100%"
      height="400px"
      data={ScatterData}
      options={options}
    />
  );
}

export default Scatter;
