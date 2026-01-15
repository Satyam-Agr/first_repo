let gamePattern = [];
let userClickedPattern = [];
let started = false;
let level = 0;
let turn=0;
const colors=["red","blue","green","yellow"];

const body=document.querySelector("body");
const dis=document.querySelector("#textDis");
const boxes=document.querySelectorAll(".box");
const HighScore=document.querySelector("#Hscore span");

function nextSequence() {
    const randomNumber = Math.floor(Math.random() * 4);
    gamePattern.push(randomNumber);
    console.log(gamePattern);
    flashBox(randomNumber);
    level++;
    dis.textContent=`Level ${level}`;
    return randomNumber;
}
function restart(message="Press any key to Start") {
    if(Number(HighScore.innerText) < level)
    {
        HighScore.innerText=level;
        alert("New High Score: "+(level));
    }
    gamePattern = [];
    userClickedPattern = [];
    started = false;
    level = 0;
    turn = 0;
    dis.innerHTML=message;
}
function flashBox(index) {
    if(!(index>=0 && index<=3)) return;
    const box=boxes[index];
    box.classList.add("flash");
    setTimeout(() => {
        box.classList.remove("flash");
    }, 250);
}

document.addEventListener("keypress", function() {
    if(!started)
    {
        nextSequence();
        started = true;
    }
});
boxes.forEach((box, index) => {
    box.addEventListener("click", function() {
        if(!started) return;
        if(index !== gamePattern[turn]) {
            restart(`Game Over! your score was <b>${level}</b><br>Press any key to Start`);
            body.classList.add("game-over");
            setTimeout(() => {
                body.classList.remove("game-over");
            }, 200);
            return;
        }
        turn++;
        userClickedPattern.push(index);
        console.log(userClickedPattern);
        if(turn === gamePattern.length) {
            turn = 0;
            userClickedPattern = [];
            setTimeout(nextSequence, 1000);
        }
    });
});