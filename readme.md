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

Piped is currently in the early stages of development. The language is still being designed and implemented. The Compiler contains a lot of bugs and the language is not yet stable. However, the language is being actively developed and improved. 

## Getting Started
### Variables
Variables in Piped are declared using the `let` keyword. Variables are always immutable and cannot be reassigned. To declare a variable, you must specify the type of the variable. Types are started with a capital letter. As of now, Piped only supports the following types:
- Int
- Bool
- Tuples of the above types
- Structs (User defined types)

Strings and Lists are not yet supported, but will be added soon.

```
let x : Int = 10;
let y : Int = 20;
let z : Int = x + y;

let myTuple : (Int, Int) = (10, 20);
let mySecondTuple : (Int, Bool, Int) = (x, false, y);
```
### Pipes
Pipes are the core of Piped. Pipes are used to pass data through a series of transformations. Pipes are declared using the `pi` keyword. Pipes can take any number of arguments and return any number of values. Pipes are called using the `|>` operator. The `|>` operator takes the result of the left hand side and passes it a# Piped Lang
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

Notice how the return type of `step1` is the argument type of `step2`. This is how pipes are connected. The return type of the first pipe must match the argument type of the second pipe. This is how data is passed through the pipes.
In this case we have `Int |> Int -> Int |>  Int -> (Int, Int) |> (Int, Int) -> Int`. The final return type of the pipeline is the return type of the last pipe.

But what if you want to connect pipes which do not have matching types? 

### Pipeline Placeholder


