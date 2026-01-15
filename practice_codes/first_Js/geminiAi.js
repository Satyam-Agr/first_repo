import { GoogleGenerativeAI } from "https://esm.run/@google/generative-ai";
const GEMINI_API_KEY="AIzaSyCu-H-UDpEQQqSEfOlxHH7ByaxJ8xquTOY";
const genAI = new GoogleGenerativeAI(GEMINI_API_KEY);
const model = genAI.getGenerativeModel({ model: "gemini-2.0-flash" });

const aiBtn=document.querySelector('#askBtn');
const aiPara=document.querySelector('#answerPara');
const request=document.querySelector('#questionInput');
aiBtn.addEventListener('click',async function(){
    const userRequest=request.value;
    request.value="";
    let result = await aiCaller(userRequest);
    aiPara.textContent=result;
});
async function aiCaller(request) {
    try {
        const result = await model.generateContent(request);
        return result.response.text();
    } catch (error) {
        console.error("Error generating content:", error);
    }
}


