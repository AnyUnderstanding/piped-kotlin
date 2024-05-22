#bin/bash
llc -filetype=obj $PWD/out.ll -o $PWD/out/out.o
clang $PWD/out/out.o -o $PWD/out/out -no-pie -O3
echo "Running the program"
time $PWD/out/out
