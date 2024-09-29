define i32 @main() 
{
   %v$115 = add i32 1, 0
   %v$116 = add i32 2, 0
   %v$117 = add i32 %v$115, %v$116
   %v$118 = add i32 3, 0
   %v$119 = mul i32 %v$117, %v$118
   %v$120 = call i32 @pipeLine$0(i32 %v$119)
   
   %v$121 = add i32 0, 0
   
   ret i32 %v$121
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeLine$0(i32 %field$0) 
{
   %v$122 = add i32 1, 0
   %v$123 = add i32 2, 0
   %v$124 = add i32 %v$122, %v$123
   %v$125 = add i32 3, 0
   %pipeLineVar$0 = mul i32 %v$124, %v$125
   
   
   %v$127 = call i32 @print(i32 %pipeLineVar$0)
   
   ret i32 %v$127
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
