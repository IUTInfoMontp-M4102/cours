let touchStartTime = undefined;
let touchStartX = undefined;
let touchStartY = undefined;
const PI = Math.PI;
const angleEpsilon = .2;

window.addEventListener('touchstart', e => {
    touchStartX = e.changedTouches[0].screenX;
    touchStartY = e.changedTouches[0].screenY;
    touchStartTime = e.timeStamp;
})

function onSwipe(angle) {
    if (-angleEpsilon <= angle && angle <= angleEpsilon) {
        // right swipe
        console.log("right");
        next_step();
    } else if (angle > PI - angleEpsilon || angle < -PI + angleEpsilon) {
        // left swipe
        console.log("left");
        prev_step();
    } else if (-PI/2 - angleEpsilon <= angle && angle <= -PI/2 + angleEpsilon) {
        // up swipe
        console.log("up");
        prev_slide();
    } else if (PI/2 - angleEpsilon <= angle && angle <= PI/2 + angleEpsilon) {
        // down swipe
        console.log("down");
        next_slide();
    }
}

window.addEventListener('touchend', e => {
    const touchDeltaX = e.changedTouches[0].screenX - touchStartX;
    const touchDeltaY = e.changedTouches[0].screenY - touchStartY;
    const touchDuration = e.timeStamp - touchStartTime;
    const touchLength = Math.sqrt(touchDeltaX * touchDeltaX + touchDeltaY * touchDeltaY);
    if (touchDuration < 500 && touchLength > 100) {
        onSwipe(Math.atan2(touchDeltaY, touchDeltaX));
    }
})