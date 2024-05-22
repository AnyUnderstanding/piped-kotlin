#bin/bash
llc -filetype=obj $PWD/out/llvm.ll -o $PWD/out/out.o
clang $PWD/out/out.o -o $PWD/out/out -no-pie -O3
echo "Running the program"
$PWD/out/out
