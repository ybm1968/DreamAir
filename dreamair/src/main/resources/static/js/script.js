const images = document.querySelectorAll('.slider span');
const sliderContainer = document.querySelector('slider-container');
const slider = document.querySelector('.slider');
const prevBtn = document.querySelector('.leftBtn');
const nextBtn = document.querySelector('.rightBtn');

let current = 1;
const imgSize = images[0].clientWidth;

slider.style.transform = `translateX(${-imgSize}px)`;

prevBtn.addEventListener('click',()=>{
    if( current <= 0) return;
    slider.style.transition = '400ms ease-in-out transform';
    current--;
    slider.style.transform = `translateX(${-imgSize * current}px)`;
})

nextBtn.addEventListener('click',()=>{
    if( current >= images.length -1 ) return;
    slider.style.transition = '400ms ease-in-out transform';
    current++;
    slider.style.transform = `translateX(${-imgSize * current}px)`;
})

slider.addEventListener('transitionend', ()=> {
    if(images[current].classList.contains('first-img')){
        slider.style.transition = 'none';
        current = images.length - 2;
        slider.style.transform = `translateX(${-imgSize * current}px)`;
    }
    if(images[current].classList.contains('last-img')){
        slider.style.transition = 'none';
        current = images.length - current;
        slider.style.transform = `translateX(${-imgSize * current}px)`;
    }
})