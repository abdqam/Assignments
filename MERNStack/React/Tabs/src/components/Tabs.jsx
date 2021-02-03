import React,{useState} from 'react'
import { Button } from '@material-ui/core';
import '../App.css'
const tabs=["tab 1","tab 2","tab 3"]
const Tabs = () => {
    const [msg,setMsg]=useState("")
    const onClickHandler = (e, value) => {
        setMsg(value + " content is showing here");
    }
    return (<>{tabs.map( (item, index) => {
        return <Button variant="contained" color="secondary" onClick={ (e) => onClickHandler(e, item) }>{ item }</Button>
    })}
    <div className="App-logo">{msg}</div>
    </>)
}

export default Tabs
