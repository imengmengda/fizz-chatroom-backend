class HelloWorld extends React.Component{

    
    render(){                                 //render here
        return (
          <div>
            <h1>HelloWorld!</h1>  
          </div>
        );
    }
}


React.render(
  <HelloWorld/>,                            //call the render function to render the html tag
  document.getElementById("content")
);