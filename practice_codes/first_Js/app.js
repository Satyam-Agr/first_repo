

let btn1=document.createElement('button');
let btn2=document.createElement('button');
btn1.textContent = 'Click Me';
btn2.textContent = 'Click Me Too';
let body=document.querySelector('img');
body.insertAdjacentElement("afterend",btn1);
body.insertAdjacentElement("afterend",btn2);
function showAlert(){
    alert('Button Clicked!');
}
btn1.onclick=showAlert;//no parentheses , as adding parentheses would invoke the function immediately
btn2.onclick=function(){
    alert('Button Clicked Too!');
};//anonymous function assigned to btn2's onclick property
let btns=document.querySelectorAll('button');
// for(let btn of btns){
//     btn.onmouseenter=function(){
//         btn.classList.toggle('yellow');
//     }
// }
function generateRandomColor(){
    const r=Math.floor(Math.random()*256);
    const g=Math.floor(Math.random()*256);
    const b=Math.floor(Math.random()*256);
    return `rgb(${r}, ${g}, ${b})`;
}
let colorbtn=document.querySelector('#colorBtn');
colorbtn.addEventListener('click',function(){
    const newColor=generateRandomColor();
    const colorBox=document.querySelector('#colorBox');
    colorBox.style.backgroundColor=newColor;
    document.querySelector('#rgbValue').textContent=newColor;
})
//https://www.youtube.com/shorts/pPdVzOzSRkQ
const nameInput=document.querySelector('#nameInput');
const namePara=document.querySelector('#nameDiv p');
nameInput.addEventListener('input',function(){
    console.log();
    const name=nameInput.value;
    if(name.length===0){
        namePara.textContent=" ";
        return;
    }
    if(!((name.charAt(name.length-1)>='a' && name.charAt(name.length-1)<='z') || (name.charAt(name.length-1)>='A' && name.charAt(name.length-1)<='Z') || name.charAt(name.length-1)===' ')){
        nameInput.value=name.slice(0,-1);
        return;
    }
    namePara.textContent=name;
});

const callerBtn=document.querySelector('#callerBtn');
const factPara=document.querySelector('#factPara');

async function fetchCatFact(){
    try{
        const response=await fetch('https://catfact.ninja/fact');
        const data=await response.json();
        factPara.textContent=data.fact;
    }
    catch(error){
        factPara.textContent="Failed to fetch cat fact. Please try again later.";
        console.error('Error fetching cat fact:',error);
    }
}
callerBtn.onclick=fetchCatFact;

