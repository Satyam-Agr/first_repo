import express from 'express';//import express
import path from 'path';//path object
import { fileURLToPath }  from "url";//for absoluti path
import {v4 as uuidv4} from 'uuid';//to generate unique ids
import methodOverride from 'method-override';//to use http verbs like patch, delete

const __filename = fileURLToPath(import.meta.url);//absoluti path of this file
const __dirname = path.dirname(__filename);//absoluti path of this file's directory

//create an express app
const app = express();

//static files middleware
app.use(express.static(path.join(__dirname, 'public')));

//data parsing middleware
app.use(express.urlencoded({ extended: true })); //to parse urlencoded form data
app.use(express.json()); //to parse json data

//method override middleware
app.use(methodOverride('_method'));

//ejs template engine setup
app.set('view engine', 'ejs')
app.set('views', path.join(__dirname, 'views'))

//to stablish a server
const port = 3000;
app.listen(port, () => {
  console.log(`Server is running on http://localhost:${port}`)
})


//to store all posts(pseudo database)
let posts = [
    {
        id: uuidv4(),
        username: "JohnDoe",
        content: "This is my first post on Quora!"
    },
    {
        id: uuidv4(),
        username: "JaneSmith",
        content: "Hello everyone! Excited to join the Quora community."
    },
    {
        id: uuidv4(),
        username: "Satyam",
        content: "Looking forward to sharing knowledge and learning from others."
    }
]; 

//route to handle home page
app.get('/', (req, res) => {
    res.redirect('/posts');
})

//route to handle post submission
app.get('/posts', (req, res) => {
    res.render('index', { posts });
})
app.post('/posts/new', (req, res) => {
    const { username, content } = req.body;
    const newPost = {
        id: uuidv4(),
        username,
        content
    };
    posts.push(newPost);
    res.redirect('/posts');
})
app.get('/posts/:id', (req, res) => {
    const { id } = req.params;
    const post = posts.find(p => p.id === id);
    if (post) {
        res.render('show', { post });
    } else {
        res.render('notFound');
    }
})
app.get('/posts/:id/edit', (req, res) => {
    const { id } = req.params;
    const post = posts.find(p => p.id === id);

    if (post) {
        res.render('edit', { post });
    } else {
        res.status(404).render('notFound');
    }
})
app.patch('/posts/:id', (req, res) => {
    const { id } = req.params;
    const { content } = req.body;
    const post = posts.find(p => p.id === id);

    if (post) {
        post.content = content;
        res.redirect('/posts');
    } else {
        res.status(404).render('notFound');
    }
})
app.delete('/posts/:id', (req, res) => {
    const { id } = req.params;
    const post = posts.find(p => p.id === id);

    if (post) {
        posts = posts.filter(p => p.id !== id);
        res.redirect('/posts');
    } else {
        res.status(404).render('notFound');
    }

})
//404 route handler
app.use((req, res) => {
    res.status(404).render('notFound');
});