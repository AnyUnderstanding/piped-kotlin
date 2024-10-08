bundle Option{
  let value: Int,
  let isSome: Bool
}

pi main() : Int {
    let x : Int = (1) |> print |> isPrime;
    (9) |> isPrime |> print;
    >> 1;
}

pi simpleLoop(n: Int) : Int {
      (n) |> print;
    >> (n) |> [ (n) |>
        (n == 0) -> 0,
        else -> (n - 1) |> simpleLoop
    ];
}


pi isPrimeOver(n: Int) : Int {
    let prime: Bool = (n) |> isPrime;
    >> (n) |> [ (x) |>
        (prime) -> x,
        else -> (x + 1) |> isPrimeOver
    ];
}

pi isPrime(n: Int) : Bool {
    >> (n) |> [ (n) |>
        (n <= 1) -> false,
        (n == 2) -> true,
        else -> (2, n) |> isPrimeAux
    ];
}

pi isPrimeAux(i: Int, n: Int) : Bool {
    >> (i, n) |> [ (i, n) |>
        ((i*i) > n) -> true,
        (((n/i)*i) < n) -> true,
        (((n/i)*i) == n) -> false,
        else -> (i + 1, n) |> isPrimeAux
    ];
}

pi fibN(x: Int, n: Int) : Int {
    (x) |> fib |> print;
    >> (n) |> [ (n) |>
        (n == 0) -> x,
        else -> (x, n - 1) |> fibN
    ];
}

pi fib(x: Int) : Int {
    >> (0, 1, x) |> fibAux;
}

pi fibAux(prev: Int, curr: Int, count: Int) : Int {
   >> (count) |> [ (c) |>
        (c == 0) -> prev,
        else -> (curr, prev + curr, c - 1) |> fib
    ];
}

