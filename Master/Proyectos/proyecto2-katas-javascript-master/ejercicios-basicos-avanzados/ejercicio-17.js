const alien = {
    name: 'Xenomorph',
    species: 'Xenomorph XX121',
    origin: 'Unknown',
    weight: 180
};

for(index in alien){
    console.log("La propiedad", index, "tiene como valor", alien[index]);
}