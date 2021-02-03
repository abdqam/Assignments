import React, { useState } from 'react';
import MessageForm from './components/MessageForm';
import MessageDisplay from './components/MessageDisplay';
    
    
function App() {
  const [currentMsgs, setCurrentMsg] = useState([]);
  const [errorcolor, setErrorColor] = useState("");
  const [wdth,setWidth]=useState("");
    const [heght,setHeight]=useState("");
  
    const youveGotMail = ( newMessage ) => {
    setCurrentMsg( currentMsgs.concat(newMessage) );
    }
    const errorColorHandler = ( error ) => {
    setErrorColor( error );
    }
    const heightWidthHandler = ( w,h ) => {
        setWidth( w);
        setHeight( h );
        }

  return (
      <>
          <MessageForm onNewMessage={ youveGotMail } errorMsg={errorColorHandler} heightWidth={heightWidthHandler}/>
          <MessageDisplay message={ currentMsgs } errorMsg={errorcolor} heights = {heght} widths={wdth} />
      </>
  );
}

export default App;