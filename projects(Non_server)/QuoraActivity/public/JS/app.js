const postBtn = document.querySelector('.new-post-btn');
const postForm = document.querySelector('.new-post-form');

postBtn.addEventListener('click', () => {
    postForm.classList.toggle('hidden');
    postBtn.textContent = postForm.classList.contains('hidden') ? 'New Post' : 'Cancel';

});
