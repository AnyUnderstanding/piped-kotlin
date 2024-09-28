define i32 @main() 
{
   %v$139 = add i32 1, 0
   %v$140 = add i32 2, 0
   %v$141 = add i32 %v$139, %v$140
   %v$142 = add i32 3, 0
   %v$143 = mul i32 %v$141, %v$142
   %v$144 = call i32 @pipeLine0(i32 %v$143)
   
   %v$145 = add i32 0, 0
   
   ret i32 %v$145
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeLine0(i32 %field0) 
{
   %v$146 = add i32 1, 0
   %v$147 = add i32 2, 0
   %v$148 = add i32 %v$146, %v$147
   %v$149 = add i32 3, 0
   %pipeLineVar0 = mul i32 %v$148, %v$149
   
   
   %v$151 = call i32 @print(i32 %pipeLineVar0)
   
   ret i32 %v$151
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
