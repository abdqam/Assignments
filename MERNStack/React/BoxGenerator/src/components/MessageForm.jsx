import react, { useState } from 'react';
    
    
const MessageForm = (props) => {
    const [msg, setMsg] = useState("");
    const [width,setWidth]=useState("");
    const [height,setHeight]=useState("");

    
    const handleSubmit = (e) => {
        e.preventDefault();
        let c= new Option().style;
        c.color=msg;
        if(c.color===msg){
            props.onNewMessage( msg );
            props.errorMsg("");
            setMsg("");
            props.heightWidth(width,height);
            setWidth("");
            setHeight("");
        }
        else {
            props.errorMsg("this text is not color style");
            setMsg("");
        }
    };
    return (
        <form onSubmit={ handleSubmit }>
            <h1>Set Message</h1>
            <textarea 
                rows="4"
                cols="50"
                placeholder="Enter your message here"
                onChange={ (e) => setMsg(e.target.value) }
                value={ msg }
            ></textarea>
            <input onChange={ (e) => setWidth(e.target.value) } value={ width } placeholder="Enter Width" />
            <input onChange={ (e) => setHeight(e.target.value) } value={ height }  placeholder="Enter Height" />
            <input type="submit" value="Send Message" />
        </form>
    );
};
    
export default MessageForm;