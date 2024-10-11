%Option = type {
   i32,
   i1
}

%$$Int$Int$$ = type {
   i32,
   i32
}

%$$Int$Int$Int$$ = type {
   i32,
   i32,
   i32
}

define i32 @main() 
{
   %v$0 = call i1 @pipeline$0()
   
   %v$1 = add i32 1, 0
   
   ret i32 %v$1
}
define i32 @simpleLoop(i32 %n) 
{
   %v$2 = call i32 @pipeline$1(i32 %n)
   
   %v$3 = call i32 @pipeline$3(i32 %n)
   
   ret i32 %v$3
}
define i32 @isPrimeOver(i32 %n) 
{
   %prime = call i1 @pipeline$4(i32 %n)
   
   
   %v$5 = call i32 @pipeline$6(i32 %n)
   
   ret i32 %v$5
}
define i1 @isPrime(i32 %n) 
{
   %v$6 = call i1 @pipeline$8(i32 %n)
   
   ret i1 %v$6
}
define i1 @isPrimeAux(i32 %i, i32 %n) 
{
   %v$7 = call i1 @pipeline$10(i32 %i, i32 %n)
   
   ret i1 %v$7
}
define i32 @fibN(i32 %x, i32 %n) 
{
   %v$8 = call i32 @pipeline$11(i32 %x)
   
   %v$9 = call i32 @pipeline$13(i32 %n)
   
   ret i32 %v$9
}
define i32 @fib(i32 %x) 
{
   %v$10 = call i32 @pipeline$14(i32 %x)
   
   ret i32 %v$10
}
define i32 @fibAux(i32 %prev, i32 %curr, i32 %count) 
{
   %v$11 = call i32 @pipeline$16(i32 %count)
   
   ret i32 %v$11
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i1 @pipeline$0() 
{
   %pipelineVar$0 = add i32 1, 0
   
   
   %pipelineVar$1 = call i32 @print(i32 %pipelineVar$0)
   
   
   %v$14 = call i1 @isPrime(i32 %pipelineVar$1)
   
   ret i1 %v$14
}
define i32 @pipeline$1(i32 %n) 
{
   
   %v$15 = call i32 @print(i32 %n)
   
   ret i32 %v$15
}
define i32 @pipeline$2(i32 %n) 
{
   %v$16 = add i32 1, 0
   %pipelineVar$0 = sub i32 %n, %v$16
   
   
   %v$18 = call i32 @simpleLoop(i32 %pipelineVar$0)
   
   ret i32 %v$18
}
define i32 @guard$0(i32 %n) 
{
   %v$19 = add i32 0, 0
   %v$20 = icmp eq i32 %n, %v$19
   
   br i1 %v$20, label %label0, label %label1
   label0:
   %v$21 = add i32 0, 0
   
   ret i32 %v$21
   label1:
   %v$22 = call i32 @pipeline$2(i32 %n)
   
   ret i32 %v$22
}
define i32 @pipeline$3(i32 %n) 
{
   
   %v$23 = call i32 @guard$0(i32 %n)
   
   ret i32 %v$23
}
define i1 @pipeline$4(i32 %n) 
{
   
   %v$24 = call i1 @isPrime(i32 %n)
   
   ret i1 %v$24
}
define i32 @pipeline$5(i32 %x) 
{
   %v$25 = add i32 1, 0
   %pipelineVar$0 = add i32 %x, %v$25
   
   
   %v$27 = call i32 @isPrimeOver(i32 %pipelineVar$0)
   
   ret i32 %v$27
}
define i32 @guard$1(i32 %x) 
{
   
   br i1 %prime, label %label2, label %label3
   label2:
   
   ret i32 %x
   label3:
   %v$28 = call i32 @pipeline$5(i32 %x)
   
   ret i32 %v$28
}
define i32 @pipeline$6(i32 %n) 
{
   
   %v$29 = call i32 @guard$1(i32 %n)
   
   ret i32 %v$29
}
define i1 @pipeline$7(i32 %n) 
{
   %v$30 = add i32 2, 0
   %v$31 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$31 to %$$Int$Int$$*
   %v$33 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %v$30, ptr %v$33
   %v$34 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %n, ptr %v$34
   
   
   %v$35 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$36 = load i32, i32* %v$35
   %v$37 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$38 = load i32, i32* %v$37
   %v$39 = call i1 @isPrimeAux(i32 %v$36, i32 %v$38)
   
   ret i1 %v$39
}
define i1 @guard$2(i32 %n) 
{
   %v$40 = add i32 1, 0
   %v$41 = icmp sle i32 %n, %v$40
   
   br i1 %v$41, label %label4, label %label5
   label4:
   %v$42 = add i1 false, 0
   
   ret i1 %v$42
   label5:
   %v$43 = add i32 2, 0
   %v$44 = icmp eq i32 %n, %v$43
   
   br i1 %v$44, label %label6, label %label7
   label6:
   %v$45 = add i1 true, 0
   
   ret i1 %v$45
   label7:
   %v$46 = call i1 @pipeline$7(i32 %n)
   
   ret i1 %v$46
}
define i1 @pipeline$8(i32 %n) 
{
   
   %v$47 = call i1 @guard$2(i32 %n)
   
   ret i1 %v$47
}
define i1 @pipeline$9(i32 %i, i32 %n) 
{
   %v$48 = add i32 1, 0
   %v$49 = add i32 %i, %v$48
   %v$50 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$50 to %$$Int$Int$$*
   %v$52 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %v$49, ptr %v$52
   %v$53 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %n, ptr %v$53
   
   
   %v$54 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$55 = load i32, i32* %v$54
   %v$56 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$57 = load i32, i32* %v$56
   %v$58 = call i1 @isPrimeAux(i32 %v$55, i32 %v$57)
   
   ret i1 %v$58
}
define i1 @guard$3(i32 %i, i32 %n) 
{
   %v$59 = mul i32 %i, %i
   %v$60 = icmp sgt i32 %v$59, %n
   
   br i1 %v$60, label %label8, label %label9
   label8:
   %v$61 = add i1 true, 0
   
   ret i1 %v$61
   label9:
   %v$62 = sdiv i32 %n, %i
   %v$63 = mul i32 %v$62, %i
   %v$64 = icmp slt i32 %v$63, %n
   
   br i1 %v$64, label %label10, label %label11
   label10:
   %v$65 = add i1 true, 0
   
   ret i1 %v$65
   label11:
   %v$66 = sdiv i32 %n, %i
   %v$67 = mul i32 %v$66, %i
   %v$68 = icmp eq i32 %v$67, %n
   
   br i1 %v$68, label %label12, label %label13
   label12:
   %v$69 = add i1 false, 0
   
   ret i1 %v$69
   label13:
   %v$70 = call i1 @pipeline$9(i32 %i, i32 %n)
   
   ret i1 %v$70
}
define i1 @pipeline$10(i32 %i, i32 %n) 
{
   %v$71 = call i8* @malloc(i32 8)
   %pipelineVar$13 = bitcast i8* %v$71 to %$$Int$Int$$*
   %v$73 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 0
   store i32 %i, ptr %v$73
   %v$74 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 1
   store i32 %n, ptr %v$74
   
   
   %v$75 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 0
   %v$76 = load i32, i32* %v$75
   %v$77 = getelementptr %$$Int$Int$$, ptr %pipelineVar$13, i32 0, i32 1
   %v$78 = load i32, i32* %v$77
   %v$79 = call i1 @guard$3(i32 %v$76, i32 %v$78)
   
   ret i1 %v$79
}
define i32 @pipeline$11(i32 %x) 
{
   
   %pipelineVar$16 = call i32 @fib(i32 %x)
   
   
   %v$81 = call i32 @print(i32 %pipelineVar$16)
   
   ret i32 %v$81
}
define i32 @pipeline$12(i32 %x, i32 %n) 
{
   %v$82 = add i32 1, 0
   %v$83 = sub i32 %n, %v$82
   %v$84 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$84 to %$$Int$Int$$*
   %v$86 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %x, ptr %v$86
   %v$87 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %v$83, ptr %v$87
   
   
   %v$88 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$89 = load i32, i32* %v$88
   %v$90 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$91 = load i32, i32* %v$90
   %v$92 = call i32 @fibN(i32 %v$89, i32 %v$91)
   
   ret i32 %v$92
}
define i32 @guard$4(i32 %n) 
{
   %v$93 = add i32 0, 0
   %v$94 = icmp eq i32 %n, %v$93
   
   br i1 %v$94, label %label14, label %label15
   label14:
   
   ret i32 %x
   label15:
   %v$95 = call i32 @pipeline$12(i32 %x, i32 %n)
   
   ret i32 %v$95
}
define i32 @pipeline$13(i32 %n) 
{
   
   %v$96 = call i32 @guard$4(i32 %n)
   
   ret i32 %v$96
}
define i32 @pipeline$14(i32 %x) 
{
   %v$97 = add i32 0, 0
   %v$98 = add i32 1, 0
   %v$99 = call i8* @malloc(i32 12)
   %pipelineVar$20 = bitcast i8* %v$99 to %$$Int$Int$Int$$*
   %v$101 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$20, i32 0, i32 0
   store i32 %v$97, ptr %v$101
   %v$102 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$20, i32 0, i32 1
   store i32 %v$98, ptr %v$102
   %v$103 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$20, i32 0, i32 2
   store i32 %x, ptr %v$103
   
   
   %v$104 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$20, i32 0, i32 0
   %v$105 = load i32, i32* %v$104
   %v$106 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$20, i32 0, i32 1
   %v$107 = load i32, i32* %v$106
   %v$108 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$20, i32 0, i32 2
   %v$109 = load i32, i32* %v$108
   %v$110 = call i32 @fibAux(i32 %v$105, i32 %v$107, i32 %v$109)
   
   ret i32 %v$110
}
define i32 @pipeline$15(i32 %curr, i32 %prev, i32 %c) 
{
   %v$111 = add i32 %prev, %curr
   %v$112 = add i32 1, 0
   %v$113 = sub i32 %c, %v$112
   %v$114 = call i8* @malloc(i32 12)
   %pipelineVar$0 = bitcast i8* %v$114 to %$$Int$Int$Int$$*
   %v$116 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %curr, ptr %v$116
   %v$117 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %v$111, ptr %v$117
   %v$118 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 2
   store i32 %v$113, ptr %v$118
   
   
   %v$119 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$120 = load i32, i32* %v$119
   %v$121 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$122 = load i32, i32* %v$121
   %v$123 = getelementptr %$$Int$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 2
   %v$124 = load i32, i32* %v$123
   %v$125 = call i32 @fib(i32 %v$120, i32 %v$122, i32 %v$124)
   
   ret i32 %v$125
}
define i32 @guard$5(i32 %c) 
{
   %v$126 = add i32 0, 0
   %v$127 = icmp eq i32 %c, %v$126
   
   br i1 %v$127, label %label16, label %label17
   label16:
   
   ret i32 %prev
   label17:
   %v$128 = call i32 @pipeline$15(i32 %curr, i32 %prev, i32 %c)
   
   ret i32 %v$128
}
define i32 @pipeline$16(i32 %count) 
{
   
   %v$129 = call i32 @guard$5(i32 %count)
   
   ret i32 %v$129
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
