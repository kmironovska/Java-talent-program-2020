test('has a constructor for initialization', () => {
    // Create an Animal class
    // Add a constructor that takes one param, the name.
    // Set this.name to the name passed in

    class Animal {
        constructor(name) {
            this.name = name;
        }

    }

    const animal = new Animal();
    const dog = new Animal('Dog');

    expect(animal.name)
        .toBeUndefined();
    expect(dog.name)
        .toBe('Dog');
});

test('constructor can have default param values', () => {
    // Create an Animal class with a constructor
    // Make your class default (using default params) the name to 'Honey Badger'


    class Animal {

        constructor(name = 'Honey Badger') {
            this.name = name;
        }

    }

    const animal = new Animal();
    const dog = new Animal('Dog');

    expect(animal.name)
        .toBe('Honey Badger');
    expect(dog.name)
        .toBe('Dog');
});

test('can have instance methods', () => {
    // Create an Animal class, pass in the name to the constructor, and add a sayName function to the class definition

    class Animal {

        constructor(name = 'Honey Badger') {
            this.name = name;
        }

        sayName = () =>
            `My name is: ${this.name}`
    }

    const animal = new Animal();

    expect(animal.sayName)
        .toBeDefined();
    expect(Animal.sayName)
        .toBeUndefined();
    expect(animal.sayName())
        .toBe('My name is: Honey Badger');
});

test('can have static methods', () => {
    // Create an Animal class, pass in the name to the constructor,
    // and add a create method that takes a name and returns an instance

    class Animal {

        constructor(name) {
            this.name = name;

        }

        static create = (name) => {
            return new Animal(name)
        }

    }

    const animal = new Animal();

    expect(animal.create)
        .toBeUndefined();
    expect(Animal.create)
        .toBeDefined();
});

test('can extend another class', () => {
    // Create an Animal class
    // Create a Dog class that extends Animal
    // Add sayName to Animal

    class Animal {
        constructor(name) {
            this.name = name;
        }

        sayName = () =>
            `${this.name}`


    }

    class Dog extends Animal {
        constructor(name) {
            super(name);

        }


    }

    const dog = new Dog('Fido');

    expect(dog instanceof Dog)
        .toBe(true);
    expect(dog instanceof Animal)
        .toBe(true);
});
