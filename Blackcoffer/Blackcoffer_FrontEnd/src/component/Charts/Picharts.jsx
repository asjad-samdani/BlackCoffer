import React from "react";
import { Chart } from "react-google-charts";
import { useState, useEffect } from "react";
import { Col, Input, Row } from "reactstrap";
import axios from "axios";

export var chartOptions = {
  title: " Sector All Data",
  is3D: true,
};

export function Picharts() {
  const [chartData, setChartData] = useState([]);
  const [sectors, setSector] = useState([]);
  const [selectedSector, setSelectedSector] = useState([]);

  function getChartdata(sectorarg) {
    const url = `http://localhost:8080/query?sector=${sectorarg}`;
    let chartData = [["Region", "Frequency"]];
    axios
      .get(url)
      .then((res) => {
        // console.log("axios res", res);
        Object.entries(res.data).forEach(([region, frequency]) => {
          chartData.push([region, frequency]);
        });
        setChartData(chartData);
      })
      .catch((e) => {
        console.log(e);
      });
  }

  useEffect(() => {
    getChartdata(selectedSector);
  }, [selectedSector]);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/sector`)
      .then((resp) => setSector(resp.data))
      .catch((e) => console.error("Error fetching data:", error));
  }, []);

  function reloadChart(event) {
    const selectedSector = event.target.value;
    console.log("Sector selected:", selectedSector);
    setSelectedSector(selectedSector);
  }

  return (
    <div>
      <Row>
        <Col>
          <Input
            name="select"
            onChange={reloadChart}
            type="select"
            placeholder="Select a sector"
            style={{
              textAlign: "center",
              borderRadius: "10px",
              fontFamily: "Arial, sans-serif",
              padding: "10px 10px",
              margin: "20px auto",
              width: "250px",
            }}
          >
            {sectors.map((sectorOption, index) => (
              <option key={index}>{sectorOption}</option>
            ))}
          </Input>
        </Col>
      </Row>
      <Chart
        chartType="PieChart"
        data={chartData}
        options={chartOptions}
        width={"100%"}
        height={"400px"}
      />
    </div>
  );
}
export default Picharts;
