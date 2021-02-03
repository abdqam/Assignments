import react from "react";

const MessageDisplay = (props) => {
    let display = {
        display: "flex"
    };
    return (
    <>
    <h1>Current Message</h1>
    <div style={display}>
        {props.message.map((item, index) => {
        let Style = {
            backgroundColor: item,
            width: props.widths,
            height: props.heights
        };
        return <div id={index} style={Style}></div>;
        })}
    </div>
    <div>{props.errorMsg}</div>
    </>
    );
};

export default MessageDisplay;
