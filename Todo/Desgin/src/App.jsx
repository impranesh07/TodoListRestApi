import React, { useEffect, useState } from 'react'

const App = () => {
  const [topic, settopic] = useState('')
  const [des, setdes] = useState('')
  const [check, setcheck] = useState(false) 
  const data={
    topic:topic,
    des:des
  }

  function dowork(e) {
    e.preventDefault();
    setcheck(true);
  }
  useEffect(()=>{
    if (check) {
    function post_data() {
      console.log("Hello world",data);

      settopic('');
    setdes('');

    setcheck(false);
    }
    post_data();  
    
    }
  },[check])
  return (
    <div>
      <form onSubmit={dowork}>
        Topic:-<input type='text' placeholder='enter topic'
         value={topic}
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
    </div>
  )
}

export default App
