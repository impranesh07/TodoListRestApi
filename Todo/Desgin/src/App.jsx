import React, { useEffect, useState } from 'react'
import axios from 'axios'
import Read from './Components/Read'
const App = () => {
  const [name, settopic] = useState('')
  const [des, setdes] = useState('')
  const [check, setcheck] = useState(false) 

  const data={
    name:name,
    des:des
  }

  function dowork(e) {
    //e.preventDefault();
    setcheck(true);
  }
  useEffect(()=>{
    if (check) {
   async function post_data() {
     try {
     const response=await axios.post("http://localhost:3232/send_data",data);
      {{alert("Data inserted")}};
     } catch (error) {
      console.log(error);
     } 
    }

   settopic('')
   setdes('') 
    setcheck(false);
    
    post_data();  
    
    }
  },[check])
  return (
    <div>
      <form onSubmit={dowork}>
        Topic:-<input type='text' placeholder='enter topic'
         value={name}
         onChange={(e)=>(
          settopic(e.target.value)
         )}
        />
        Des:-<textarea type='text' placeholder='enter 40 words' required 
        value={des}
        onChange={(e)=>(
         setdes(e.target.value)
        )}
        />
        <button>Submit</button>
      </form>

        <div className="read">
          <Read/>
        </div>

    </div>
  )
}

export default App
