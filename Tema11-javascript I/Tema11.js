// Ex1
function getStats(arr) {
	for (let i in arr) {
		if (Number.isNaN(arr[i])) {
			console.log(NaN);
		} else if (Array.isArray(arr[i])) {
			console.log("Array");
		} else {
			console.log(typeof arr[i]);
		}
	}
}

var arr = [
	1,
	2,
	"hello",
	NaN,
	{
		city: "Iasi",
		zip: null,
	},
	[11, 12],
	undefined,
	undefined,
	undefined,
];

getStats(arr);

console.log("");

// Ex2
function addFF(x) {
	return x;
}

function addF(x) {
	return (y) => addFF(y) + x;
}

let add = addF(13);

console.log(add(10));
console.log(add(-5));

console.log("");

// Ex3
function limit(fn, max) {
	return (x, y) => {
		if (this.max === undefined) {
			this.max = max;
		}

		this.max--;

		if (this.max > -1) {
			return fn(x, y);
		}
	};
}

let limitAdd = limit(add1, 2);

console.log(limitAdd(3, 5));
console.log(limitAdd(11, 23));
console.log(limitAdd(5, 10));

function add1(x, y) {
	return x + y;
}

console.log("");

// Ex4
function whatIsInAName(arr, obj) {
	const matchList = [];

	for (let i in arr) {
		let ok = true;
		const arrElemKeys = Object(Object.keys(arr[i]));

		for (const objKey in obj) {
			if (!arrElemKeys.includes(objKey) || arr[i][objKey] !== obj[objKey]) {
				ok = false;
			}
		}

		if (ok) {
			matchList.push(arr[i]);
		}
	}

	return matchList;
}

const rez1 = whatIsInAName(
	[
		{
			first: "Romeo",
			last: "Montague",
		},
		{
			first: "Mercutio",
			last: null,
		},
		{
			first: "Tybalt",
			last: "Capulet",
		},
	],
	{
		last: "Capulet",
	}
);
console.log(rez1);

const rez2 = whatIsInAName(
	[
		{
			apple: 1,
		},
		{
			apple: 1,
		},
		{
			apple: 1,
			bat: 2,
		},
	],
	{
		apple: 1,
	}
);
console.log(rez2);

const rez3 = whatIsInAName(
	[
		{
			a: 1,
			b: 2,
			c: 3,
		},
	],
	{
		a: 1,
		b: 9999,
		c: 3,
	}
);
console.log(rez3);
