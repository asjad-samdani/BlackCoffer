import React from "react";
import { Container, Row, Col } from "reactstrap";
import Header from "./component/Header";
import Picharts from "./component/Charts/Picharts";
import { BarChart } from "./component/Charts/Barchart";
import Scatter from "./component/Charts/Scatter";
import { Bar } from "./component/Charts/Bar";

const App = () => {
  return (
    <>
      <Header />
      <Container>
        <Row>
          <Col style={borderStyle}>
            <Picharts />
          </Col>
        </Row>
        <br />
        <Row>
          <Col style={borderStyle}>
            <BarChart />
          </Col>
        </Row>
        <br />
        <Row>
          <Col style={borderStyle}>
            <Scatter />
          </Col>
        </Row>
        <br />

        <Row>
          <Col style={borderStyle}>
            <Bar />
          </Col>
        </Row>
      </Container>
    </>
  );
};
const borderStyle = {
  border: "2px solid ",
};
export default App;
