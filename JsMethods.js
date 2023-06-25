let items = [
  { name: "Bike", price: 100 },
  { name: "TV", price: 200 },
  { name: "Album", price: 10 },
  { name: "Book", price: 50 },
  { name: "Phone", price: 500 },
  { name: "Computer", price: 800 },
  { name: "Keyboard", price: 120 },
];

let num = [1,2,3,4,5,6,7,8,9,10];

let newItems = num.splice(3,2,4,5);
console.log(newItems);
console.log(num);
