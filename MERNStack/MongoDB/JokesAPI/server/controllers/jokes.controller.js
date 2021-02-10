// import Joke from '../Models/jokes.model'
const Joke = require('../Models/jokes.model');


module.exports.createJoke = (request, response) => {
    Joke.create(request.body)
        .then(joke => response.json(joke))
        .catch(err => response.json(err));
}
module.exports.getAll = (request,response) => {
    Joke.find({})
    .then(jokes => response.json(jokes))
    .catch(err => response.json(err));
}
module.exports.getById = (request,response) => {
    Joke.findById({_id:request.params.id})
    .then(joke => response.json(joke))
    .catch(err => response.json(err));
}
module.exports.deleteJoke = (request,response) => {
    Joke.remove({_id:request.params.id})
    .then(joke => response.json(joke))
    .catch(err => response.json(err));
}
module.exports.updateJoke = (request,response) => {
    Joke.updateOne({_id:request.params.id},{$set:request.body})
    .then(joke => response.json(joke))
    .catch(err => response.json(err));
}

module.exports.getRandom = (request,response) => {
    Joke.aggregate([ {$sample: {size: 1}} ])
    .then(joke => response.json(joke))
    .catch(err => response.json(err));
}