const users = [
  { name: "Tony", years: 43 },
  { name: "Peter", years: 18 },
  { name: "Natasha", years: 14 },
  { name: "Bruce", years: 32 },
  { name: "Khamala", years: 16 },
];

let adultsUsers = [];
let childrenUsers = [];

for (const user of users) {
  if(user.years >= 18){
    adultsUsers.push(user);
  }
  else if(user.years < 18){
    childrenUsers.push(user);
  }
  
}

console.log("Los usuarios mayores de edad son:", adultsUsers, " y los menores de edad:", childrenUsers
);
