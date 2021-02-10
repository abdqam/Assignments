const JokesController = require('../controllers/jokes.controller');

module.exports = app => {
    app.post('/api/jokes/new', JokesController.createJoke);
    app.get('/api/jokes',JokesController.getAll);
    app.get('/api/jokes/:id',JokesController.getById);
    app.delete('/api/jokes/delete/:id',JokesController.deleteJoke);
    app.put('/api/jokes/update/:id',JokesController.updateJoke);
    app.get('/api/random/jokes',JokesController.getRandom);

}