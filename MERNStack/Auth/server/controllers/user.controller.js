const { User, Country, Book } = require("../models/user.model");
const jwt = require("jsonwebtoken");
const bcrypt = require('bcrypt');
require("dotenv").config();

module.exports.findUser = (req, res) => {
    User.findOne({ _id: jwt.decode(req.cookies.usertoken).id }).populate('books country')
        .then(async user => res.json(user))
        .catch(err => res.json(err))
}
module.exports.register = (req, res) => {
    User.create(req.body)
        .then(user => {
            const userToken = jwt.sign({
                id: user._id
            }, process.env.SECRET_KEY)
            res
                .cookie("usertoken", userToken, {
                    httpOnly: true
                })
                .json({ msg: "success!", user: user, token: userToken });
        })
        .catch(err => res.status(400).json(err));
}
module.exports.login = async (req, res) => {
    const user = await User.findOne({ email: req.body.email }).populate('books country');
    if (user === null) {
        // email not found in users collection
        return res.sendStatus(400);
    }
    // if we made it this far, we found a user with this email address
    // let's compare the supplied password to the hashed password in the database
    const correctPassword = await bcrypt.compare(req.body.password, user.password);
    if (!correctPassword) {
        // password wasn't a match!
        return res.sendStatus(400);
    }
    // if we made it this far, the password was correct
    const userToken = jwt.sign({
        id: user._id
    }, process.env.SECRET_KEY);
    // note that the response object allows chained calls to cookie and json
    res
        .cookie("usertoken", userToken, {
            httpOnly: true
        })
        .json({ msg: "success!", user: user, token: userToken });
}

module.exports.logout = (req, res) => {
    res.clearCookie('usertoken');
    res.sendStatus(200);
}
module.exports.createCountry = (req, res) => {
    Country.create(req.body)
        .then(country => res.json(country))
        .catch(err => res.json(err))
}
module.exports.allCountries = (req, res) => {
    Country.find({})
        .then(countries => res.json(countries))
        .catch(err => res.json(err))
}
module.exports.createBook = (req, res) => {
    Book.create(req.body)
        .then(book => res.json(book))
        .catch(err => res.json(err))
}
module.exports.findAllBooks = (req, res) => {
    Book.find({})
        .then(books => res.json(books))
        .catch(err => res.json(err))
}
module.exports.findBook = (req, res) => {
    Book.findOne({ _id: req.params.id })
        .then(book => res.json(book))
        .catch(err => res.json(err))
}
module.exports.addfav = (req, res) => {
    const { id } = req.body;
    User.findOneAndUpdate({ _id: req.params.id }, { $addToSet: { books: id } }, { new: true, runValidators: true }).populate('books')
        .then(updateduser => res.json(updateduser))
        .catch(err => res.json(err))
}