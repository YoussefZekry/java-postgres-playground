let items = [
	{name: 'Bike', price: 100},
	{name: 'TV', price: 200},
	{name: 'Album', price: 10},
	{name: 'Book', price: 50},
	{name: 'Phone', price: 500},
	{name: 'Computer', price: 800},
	{name: 'Keyboard', price: 120},
];

let newItems = items.some((item)=> {
	return item.price >= 1000;
});
console.log(newItems);