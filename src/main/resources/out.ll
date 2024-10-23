%Foo = type {
   i32
}

define i32 @main() 
{
   %v$0 = add i32 10, 0
   %v$1 = call i8* @malloc(i32 4)
   %foo = bitcast i8* %v$1 to %Foo*
   %v$3 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   store i32 %v$0, ptr %v$3
   
   
   %v$4 = call i32 @pipeline$0(%Foo* %foo)
   
   %v$5 = add i32 1, 0
   
   ret i32 %v$5
}
define i32 @printFoo(%Foo* %foo) 
{
   %v$6 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$7 = load i32, i32* %v$6
   %v$8 = call i32 @pipeline$1(i32 %v$7)
   
   ret i32 %v$8
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$0(%Foo* %foo) 
{
   
   
   %v$9 = call i32 @printFoo(%Foo* foo)
   
   ret i32 %v$9
}
define i32 @pipeline$1(i32 %foo$bar) 
{
   
   %v$10 = call i32 @print(i32 %foo$bar)
   
   ret i32 %v$10
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
