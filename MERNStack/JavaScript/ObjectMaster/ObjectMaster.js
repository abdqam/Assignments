const pokémon = Object.freeze([
    { "id": 1,   "name": "Bulbasaur",  "types": ["poison", "grass"] },
    { "id": 5,   "name": "Charmeleon", "types": ["fire"] },
    { "id": 9,   "name": "Blastoise",  "types": ["water"] },
    { "id": 12,  "name": "Butterfree", "types": ["bug", "flying"] },
    { "id": 16,  "name": "Pidgey",     "types": ["normal", "flying"] },
    { "id": 23,  "name": "Ekans",      "types": ["poison"] },
    { "id": 24,  "name": "Arbok",      "types": ["poison"] },
    { "id": 25,  "name": "Pikachu",    "types": ["electric"] },
    { "id": 37,  "name": "Vulpix",     "types": ["fire"] },
    { "id": 52,  "name": "Meowth",     "types": ["normal"] },
    { "id": 63,  "name": "Abra",       "types": ["psychic"] },
    { "id": 67,  "name": "Machamp",    "types": ["fighting"] },
    { "id": 72,  "name": "Tentacool",  "types": ["water", "poison"] },
    { "id": 74,  "name": "Geodude",    "types": ["rock", "ground"] },
    { "id": 87,  "name": "Dewgong",    "types": ["water", "ice"] },
    { "id": 98,  "name": "Krabby",     "types": ["water"] },
    { "id": 115, "name": "Kangaskhan", "types": ["normal"] },
    { "id": 122, "name": "Mr. Mime",   "types": ["psychic"] },
    { "id": 133, "name": "Eevee",      "types": ["normal"] },
    { "id": 144, "name": "Articuno",   "types": ["ice", "flying"] },
    { "id": 145, "name": "Zapdos",     "types": ["electric", "flying"] },
    { "id": 146, "name": "Moltres",    "types": ["fire", "flying"] },
    { "id": 148, "name": "Dragonair",  "types": ["dragon"] }
]);

const idPokemon = pokémon.filter( p => p.id%3 ===0 );
console.log("pokémon objects where the id is evenly divisible by 3:");
console.log(idPokemon);
const firePokemon = pokémon.filter( p => p.types === "fire" );
console.log(`pokémon objects that are "fire" type: `);
console.log(firePokemon);
const typesPokemon = pokémon.filter( p => p.types.length >1 );
console.log(`pokémon objects that have more than one type: `);
console.log(typesPokemon);
const namesPokemon = pokémon.filter( p => p.name );
console.log(`names of the pokémon: `);
console.log(namesPokemon);
const greaterPokemon = pokémon.filter( p => p.id>99 ).map(p=>p.name);
console.log("names of pokémon with an id greater than 99:");
console.log(greaterPokemon);
const poisonPokemon = pokémon.filter( p => p.types.includes("poison") ).map(p=>p.name);
console.log("names of the pokémon whose only type is poison");
console.log(poisonPokemon);
const flyingPokemon = pokémon.filter( p => p.types[1]== "flying").map(p=>p.types[0]);
console.log("array containing just the first type of all the pokémon whose second type is 'flying'");
console.log(flyingPokemon);
const normalPokemon = pokémon.filter( p => p.types.includes("normal")).length;
console.log("count of the number of pokémon that are 'normal' type");
console.log(normalPokemon);