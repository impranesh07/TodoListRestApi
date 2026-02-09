import React, { useEffect,useState } from 'react'
import axios from 'axios'
const Read = () => {
  const [data, getdata] = useState([])
  const [relode, getrelode] = useState(false)
    useEffect(()=>{
       async function get_data() {
          try {
            const response = await axios.get("http://localhost:3232/get_data");
           // console.log(response.data);
            getdata(response.data);
          } catch (error) {
            console.log(error);
          }    
        }
        get_data();
    },[])
  
    async function delete_data(elem) {
          try {
            const data_del=await axios.put(`http://localhost:3232/delete_data/${elem}`)
            {{alert("Data Deleted Sucessfully")}}
            getrelode(true)
          } catch (error) {
            console.log(error);
          }
    }
    if (relode) {
      window.location.reload()
    }
     
return (
    <div>
      <h3>Read Data</h3>
      <div className="data" style={{backgroundColor:"blue"}}>
        {data.map((item,index)=>(
          <div className="box" key={index} style={{backgroundColor:"red", color:"white"}}>
            <h4>{item.name}</h4>
            <p>{item.des}</p>
            <button
            onClick={()=>(
              delete_data(item.name)
            )}
            >Delete</button>
          </div>
        ))}
      </div>
    </div>
  )
}

export default Read
