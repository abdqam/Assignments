import React,{useState} from 'react'

const ToDo = () => {
    const [toDoList,setToDoList]=useState([{name:"this is my first task",checked:true},{name:"this is my second task",checked:false}]);
    const toDoHandler=()=>{
        let name = document.getElementById("text").value;
        setToDoList(toDoList.concat({name:name,checked:false}))
        document.getElementById("text").value="";
    }
    const changeStatus=(e,index)=>{
        setToDoList(toDoList.map((item,i)=>i===index?
        {name:item.name,checked:e.target.checked}:
        {name:item.name,checked:item.checked}
        ))
    }
    const deleteToDo=(index)=>{
        setToDoList(toDoList.filter((item,i)=>i!==index))
    }
    return (
        <>
        <div>
            {
            toDoList.map((item,index)=>{
                return <div key={index}>
                        {item.checked?
                        <del>{item.name}</del>:
                        <span>{item.name}</span>}
                        <input type="checkbox" id={index} checked={item.checked} onClick={(e)=>changeStatus(e,index)}/>
                        <input type="button" id={index}  value="Delete" onClick={()=>deleteToDo(index)}/>
                    </div>
            })
            }
        </div>
        <div>
            <textarea name="" id="text" cols="25" rows="2"/>
            <input type="button" value="Add!" onClick={toDoHandler}/>
        </div>
        </>
    )
}

export default ToDo