# Piped Lang
## What is Piped
Piped is a functional programming language. Unlike regular programming languages, Piped does not have functions. Instead, Piped has pipes.
A pipe is very similar to a function, but differs in the way data is passed to it. In a function, data is passed as arguments. In a pipe, data is passed through the pipe. This allows for a more functional programming style, where data is passed through a series of pipes, each transforming the data in some way.
```
pi add(a : Int, b : Int) : Int {
    >> a + b;
}

...
print(add(1, 2)); ❌ Invalid pipe

(1, 2) |> add |> print; ✅ Valid pipe
```
## The State of Piped
> [!NOTE]
> Piped is a fun project and is not intended to be used in production.

Piped is currently in the early stages of development. The language is still being designed and implemented. The compiler contains a lot of bugs and the language is not yet stable. However, the language is being actively developed and improved. 

## Getting Started
### Variables
Variables in Piped are declared using the `let` keyword. Variables are always immutable and cannot be reassigned. To declare a variable, you must specify the type of the variable. Types start with a capital letter. As of now, Piped only supports the following types:
- Int
- Bool
- Tuples of the above types
- Bundles (user-defined types, similar to structs in C)

Strings, Floats and Lists are not yet supported, but will be added soon.

```
let x : Int = 10;
let y : Int = 20;
let z : Int = x + y;

let myTuple : (Int, Int) = (10, 20);
let mySecondTuple : (Int, Bool, Int) = (x, false, y);
```
### Pipes
Pipes are the core of Piped. Pipes are used to pass data through a series of transformations. Pipes are declared using the `pi` keyword. Pipes can take any number of arguments and return any number of values. Pipes are called using the `|>` operator. The `|>` operator takes the result of the left hand side and passes it to the right hand side.
```
pi step1(a : Int) : Int {
    >> a + 1;
}
pi step2(a : Int) : (Int, Int) {
    >> (a, a);
}

pi step3(a : Int, b : Int) : Int {
    >> a + b;
}

pi main() : Int {
    // your first pipeline 🎉
    >> (10) |> step1 |> step2 |> step3;
}
```
> [!NOTE]
> `>>` is the return operator. It is used to return a value from a pipe or scope.

Notice how the return type of `step1` is the argument type of `step2`. This is how pipes are connected. The return type of the first pipe must match the argument type of the second pipe. This is how data is passed through the pipes.
In this case we have `Int |> Int -> Int |>  Int -> (Int, Int) |> (Int, Int) -> Int`. The final return type of the pipeline is the return type of the last pipe.

But what if you want to connect pipes which do not have matching types? 

### Pipeline Placeholder
Suppose you have two pipes `pipe1` and `pipe2` where the return type of `pipe1` does not match the argument type of `pipe2`. You can use a pipeline placeholder to connect the two pipes. 

```
pi pipe1(a : Int) : Int {
    >> a + 1;
}

pi pipe2(a : Int, b : Int) : Int {
    >> a + b;
}
```
Calling `(1) |> pipe1 |> pipe2` won't work because the return type of `pipe1` does not match the argument type of `pipe2`. 
To fix this, you can use a pipeline placeholder denoted by `#x` where `x` is the index of the returned element.

To fix the above example, you can do the following: `(1) |> pipe1 |> (#0, 3) |> pipe2`. 
This calls `pipe1` with `1`, then calls `pipe2` with the first returned element of `pipe1` and `3`.

Now suppose you have a pipe `pipe3` which returns 3 integers. You can use multiple placeholders to connect the pipes.
` (...) |> pipe3 |> (#0, #2) |> pipe2` will call `pipe3` and pass the first and the third returned element to `pipe2`.

### Guards
In Piped there are no if statements. Instead, you can use guards. Guards are similar to if statements, but they work better in piplines. To add a guard to a pipeline do the following:
```

pi add(a : Int, b : Int) : Int {
    >> a + b;
}

pi main() : Bool {
    >> (1, 2) |> add |> [(x) |>
     (x >= 10) -> 1,
     (x < 10) -> 2,
     else -> 3
    ];
}
```
> [!IMPORTANT]
> The else block is always required.

You can also write more complex guards:
```
pi main() : Bool {
    >> (1, 2) |> [(x, y) |>
     (x + y>= 2) -> 1,
     (x == y) -> 2,
     (x < 10 && x > 5) -> 3,
     (x == y) -> 3,
     else -> 4
    ] |> (#0, 1) |> add;
}
```

> [!NOTE]
> `(x + y>= 2)` and `(x == y)` can both be true. In this case the first guard that is true is executed.

### Bundles
Bundles are user-defined types. They are similar to structs in C. You can define a bundle using the `bundle` keyword. 
```
bundle Point {
    x : Int;
    y : Int;
}
```
T initialize a bundle:

```
let myPoint : Point = Point(10, 20);
```

### Scopes
Scopes can return values.
```
pi main() : Int {
    let a : Int = 10;
    let b : Int ={
        let x : Int = 10;
        let y : Int = 20; 
        // let a : Int = 10; ❌ a is already defined
        >> x + y;
    }
    // x can be created here because x is not in the same scope as the previous x
    let x : Int = b;
}
```

## Roadmap

✅ - Completed \
🚧 - Work in progress \
❌ - Not started 
---
[✅] Add support for Ints \
[✅] Add support for Booleans \
[✅] Add support for Tuples \
[✅] Add support for Bundles \
[✅] Add support for Pipes \
[✅] Add support for Pipeline Placeholders \
[✅] Add support for Guards \
[✅] Add support for Scopes \
[🚧] Fix Bugs and add Tests \
[🚧] Improve performance and codegen \
[❌] Add support for Strings \
[❌] Add support for Floats \
[❌] Add support for Lists \
[❌] Add support for Rust-like enums \
[❌] Add support for overloading \
[❌] Add support for Imports \
[❌] Add C Interop \
[❌] Add `@Async` annotation \
[❌] Add `@Cached` annotation 

