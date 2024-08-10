
let globalImgs;
let globalNames;
let globalTypes;

 getServletImages();
 //getServletNames();
 //getServletTypes(); 

   
   function standardCatalog(){
   
   let xhr = new XMLHttpRequest();
   
   let imagesContainer = document.getElementById("imagesContainer");
   
    let labels = [];
   
   xhr.onreadystatechange = function(){
	   if(xhr.readyState == 4 && xhr.status == 200){
		   
		  let imgs = JSON.parse(xhr.responseText);
		   
		  //  console.log(originals);
		    
		    for(let i = 0; i < imgs.length; i++) {
                    
                    imgs[i] = "data:image/png;base64," + imgs[i];
                    
                    labels[i] = document.createElement("img");
                    
                    labels[i].setAttribute("src", imgs[i]);
                    
                    imagesContainer.appendChild(labels[i]);
                    
                    
                    console.log(imgs[i]);
                   
                }
		   
	   }else{
		console.log("mmmmmmmmmmmm");
	   }
   }
    // Faça a requisição GET para o servlet
    
      
        xhr.open("POST", "http://localhost:8080/Pokedex/SearchProcess", true);
        xhr.send();
        globalImgs = imgs;
   
   }
   
   function getServletImages(){
   let xhr = new XMLHttpRequest();
   
   let imagesContainer = document.getElementById("imagesContainer");
   
    let labels = [];
   
   xhr.onreadystatechange = function(){
	   if(xhr.readyState == 4 && xhr.status == 200){
		   
		  let imgs = JSON.parse(xhr.responseText);
		   
		  //  console.log(originals);
		    
		    for(let i = 0; i < imgs.length; i++) {
                    
                    imgs[i] = "data:image/png;base64," + imgs[i];
                     
                   
                }
                
                labels = imgs;
		   
	   }else{
		console.log("mmmmmmmmmmmm");
	   }
   }
    // Faça a requisição GET para o servlet
    
      
        xhr.open("POST", "http://localhost:8080/Pokedex/SearchProcess", true);
        xhr.send();
        globalImgs = labels;
   }
   
   
   function getServletNames(){
   let xhr = new XMLHttpRequest();
   
   let imagesContainer = document.getElementById("imagesContainer");
   
    let labels = [];
   
   xhr.onreadystatechange = function(){
	   if(xhr.readyState == 4 && xhr.status == 200){
		   
		  let names = JSON.parse(xhr.responseText);
		   
		  //  console.log(originals);
		    
		    for(let i = 0; i < names.length; i++) {
                    
                    names[i] = "data:image/png;base64," + names[i];
                     
                   
                }
                
                labels = names;
		   
	   }else{
		console.log("mmmmmmmmmmmm");
	   }
   }
    // Faça a requisição GET para o servlet
    
      
        xhr.open("POST", "http://localhost:8080/Pokedex/SearchProcessNames", true);
        xhr.send();
        globalNames = labels;
   }
   
   function getServletTypes(){
   let xhr = new XMLHttpRequest();
   
   let imagesContainer = document.getElementById("imagesContainer");
   
    let labels = [];
   
   xhr.onreadystatechange = function(){
	   if(xhr.readyState == 4 && xhr.status == 200){
		   
		  let tipos = JSON.parse(xhr.responseText);
		   
		  //  console.log(originals);
		    
		    for(let i = 0; i < tipos.length; i++) {
                    
                    tipos[i] = "data:image/png;base64," + tipos[i];
                   
                }
                
                labels = tipos;
		   
	   }else{
		console.log("mmmmmmmmmmmm");
	   }
   }
    // Faça a requisição GET para o servlet
    
      
        xhr.open("POST", "http://localhost:8080/Pokedex/SearchProcessTypes", true);
        xhr.send();
        globalTypes = labels;
   }
   
   function getCatalog(){   
   
   
   let imgLabels = [];
   let nameLabels = [];
   let typeLabels = [];
   let containers = [];
		  
		  //  console.log(originals);
		    
		    for(let i = 0; i < globalImgs.length; i++) {
				
				containers[i] = document.createElement("div");
				containers[i].setAttribute("name", "card" + i);
                    
                    globalImgs[i] = "data:image/png;base64," + globalImgs[i];
                    
                    imgLabels[i] = document.createElement("img");
                    
                    imgLabels[i].setAttribute("src", globalImgs[i]);
                    
                    containers[i].appendChild(imgLabels[i]);
                    
                    //imagesContainer.appendChild(labels[i]);
                    
                    
                    globalNames[i] = "data:image/png;base64," + globalNames[i];
                    
                    nameLabels[i] = document.createElement("img");
                    
                    nameLabels[i].setAttribute("src", globalNames[i]);
                    
                    containers[i].appendChild(nameLabels[i]);
                    
                    //imagesContainer.appendChild(labels[i]);
                    
                    
                    globalTypes[i] = "data:image/png;base64," + globalTypes[i];
                    
                    typeLabels[i] = document.createElement("img");
                    
                    typeLabels[i].setAttribute("src", globalTypes[i]);
                    
                    containers[i].appendChild(nameLabels[i]);
                    
                    //imagesContainer.appendChild(labels[i]);
                    
                    imagesContainer.appendChild(containers[i]);
                    
                   
                }
		   
	   }
    // Faça a requisição GET para o servlet
    
   
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
  
   
   