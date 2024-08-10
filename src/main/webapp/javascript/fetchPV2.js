let globalCards;

function getCards(){
	
	let xhr = new XMLHttpRequest();
	
	let mainPanel = document.getElementById("imagesContainer");
	
	let labels = new Array();
	
	xhr.onreadystatechange = function() {
	if(xhr.readyState == 4 && xhr.status == 200){
		let catalog = JSON.parse(xhr.responseText);
		
		for(let i = 0; i < catalog.length; i++) {
			
			console.log(catalog[i][0]);
			console.log(catalog[i][1]);
			console.log(i);
			
			
			labels[i] = document.createElement("div");
			labels[i].setAttribute("name",catalog[i][1]);
			labels[i].setAttribute("class",catalog[i][2]);
			
			let img = document.createElement("img");
			img.setAttribute("src","data:image/png;base64," + catalog[i][0]);
			
			let contentArea = document.createElement("span");
			contentArea.innerHTML = catalog[i][1] + "<br>" + catalog[i][2];
			
			
			img.style.maxWidth = "50%";
			img.style.maxHeight = "200px";
			img.style.objectFit = "cover";
			img.style.borderRadius = "8px";
			
			contentArea.style.display = "block";
			contentArea.style.marginTop = "8px";
			contentArea.style.fontWeight = "bold";
			contentArea.style.color = "#333";
			
			labels[i].style.border = "1px solid #ccc";
			labels[i].style.flex = "0 0 calc(48% - 10px)";
			labels[i].style.padding = "10px";
			labels[i].style.margin = "10px";
			labels[i].style.textAlign = "center";
			labels[i].style.borderRadius = "8px";
			
			mainPanel.style.display = "flex";
			mainPanel.style.flexWrap = "wrap";
			mainPanel.style.justifyContent = "space-between";
			mainPanel.style.margin = "10px";
			
			
			labels[i].appendChild(img);
			labels[i].appendChild(contentArea);
			
			mainPanel.appendChild(labels[i]);
			
			
			
			//labels[i].setAttribute("name","card" + i);
		
		}
		
		console.log(catalog);
		
	}else{
		console.log("MERDAAAAAA");
	}
	}
	
	xhr.open("POST","http://localhost:8080/Pokedex/CatalogServlet" ,true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send();
	
	globalCards = labels;
}




function customSearch(){
	let mainPanel = document.getElementById("imagesContainer");
	
	let userInput = document.getElementById("userInput").value;
	
	mainPanel.innerHTML = "";
	
	if(userInput == ""){
	    getCards();
	    return;
	}else{
		for(let i = 0;i < globalCards.length;i++){
			if(globalCards[i].getAttribute("name") == userInput || globalCards[i].getAttribute("class") == userInput){
				mainPanel.appendChild(globalCards[i]);
			}
			//console.log(globalCards[i][1]);
			//console.log(globalCards[i][2]);
		}
		
	}
	
	
}














