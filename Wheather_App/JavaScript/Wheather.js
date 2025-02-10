/*
URL="https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/NameOFCity?unitGroup=us&key=229NYPZWLU4QQLK62EJDAQPMH&contentType=json"
*/

const city=document.getElementById("City_Name");
const Box=document.getElementsByClassName("box")
const Box1=document.getElementById("tempreture");
const Box2=document.getElementById("Humidity");
const Box3=document.getElementById("Description");
const Box4=document.getElementById("Pressure");
const Box5=document.getElementById("Dew");
async function Wheather() 
{

    try{
        const Name=city.value;

        if (!Name) {
            alert("Please enter a city name!");
            return;
        }
        const URL=`https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/${Name}?unitGroup=us&key=229NYPZWLU4QQLK62EJDAQPMH&contentType=json`;
        const data= await fetch(URL);  
        if (!data.ok) {
            throw new Error(`City not found. Please enter a valid city name.`);
        }
        const result=await data.json();

        if (!result.currentConditions) {
            throw new Error(`City not found. Please enter a valid city name.`);
        }
        console.log(result);
        // console.log(Name);
        Box1.innerHTML=Name+" : "+result.currentConditions.temp+" "+"°F";
        Box2.innerHTML=result.currentConditions.humidity+" %";
        Box3.innerHTML=result.description;
        Box4.innerHTML=result.currentConditions.pressure+" Hg";
        Box5.innerHTML=result.currentConditions.dew+"°F";




        const currentHour = new Date().getHours(); // Get local time

        // Change Background Based on Time
        if (currentHour >= 5 && currentHour < 12) {
            document.body.style.backgroundImage = "url('https://wallpapercave.com/wp/wp8798403.jpg')";
        } else if (currentHour >= 12 && currentHour < 17) {
            document.body.style.backgroundImage = "url('https://i.pinimg.com/736x/52/ce/c7/52cec7aece3c45c3efa7ea7786daa7bf.jpg')";
        } else if (currentHour >= 17 && currentHour < 23) {
            document.body.style.backgroundImage = "url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1_rXBNYtvODOIWN0EkgaH3Qkdoo1yvLp06A&s')";
        } else {
            document.body.style.backgroundImage = "url('https://i.pinimg.com/736x/64/fd/57/64fd578e296268b8b24f9f9fd33b7ecb.jpg')";
        }

        document.body.style.backgroundSize = "cover"; 
        document.body.style.transition="2s";

    }catch(error){
        console.log(error);
        alert(`Error :: ${error}`);
    }
    
    // if()
}

function EraseData(){
    city.value="";
    Box1.innerHTML=" - "+"°F";
    Box2.innerHTML=" -  %";
    Box3.innerHTML= " - ";
    Box4.innerHTML=" -  Hg";
    Box5.innerHTML=" - °F";

    // document.body.style.backgroundImage = "url('https://i.pinimg.com/736x/64/fd/57/64fd578e296268b8b24f9f9fd33b7ecb.jpg')";
}