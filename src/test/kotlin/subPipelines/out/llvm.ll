%Foo = type {
   i32,
   i32
}

%$$Int$Int$$ = type {
   i32,
   i32
}

%$$Foo$Int$$ = type {
   %Foo,
   i32
}

define i32 @main() 
{
   %v$259 = call i32 @pipeline$19()
   
   %x = add i32 1, 0
   
   
   %v$261 = call i32 @pipeline$21(i32 %x)
   
   %v$262 = add i32 5, 0
   %v$263 = add i32 10, 0
   %v$264 = call i8* @malloc(i32 8)
   %foo = bitcast i8* %v$264 to %Foo*
   %v$266 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   store i32 %v$262, ptr %v$266
   %v$267 = getelementptr %Foo, ptr %foo, i32 0, i32 1
   store i32 %v$263, ptr %v$267
   
   
   %v$268 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$269 = load i32, i32* %v$268
   %v$270 = getelementptr %Foo, ptr %foo, i32 0, i32 1
   %v$271 = load i32, i32* %v$270
   %v$272 = call i32 @pipeline$23(%Foo %foo, i32 %v$269, i32 %v$271)
   
   %v$273 = add i32 0, 0
   
   ret i32 %v$273
}
define i32 @add(i32 %a, i32 %b) 
{
   %v$274 = add i32 %a, %b
   
   ret i32 %v$274
}
define i32 @combine(%Foo %foo, i32 %value) 
{
   %v$275 = getelementptr %Foo, ptr %foo, i32 0, i32 0
   %v$276 = load i32, i32* %v$275
   %v$277 = mul i32 %v$276, %value
   %v$278 = getelementptr %Foo, ptr %foo, i32 0, i32 1
   %v$279 = load i32, i32* %v$278
   %v$280 = add i32 %v$277, %v$279
   
   ret i32 %v$280
}
define i32 @print(i32 %value) 
{
   call i32 (ptr, ...) @printf(ptr noundef @.str, i32 noundef %value)
   
   
   ret i32 %value
}
define i32 @pipeline$18() 
{
   %v$281 = add i32 1, 0
   %v$282 = add i32 2, 0
   %v$283 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$283 to %$$Int$Int$$*
   %v$285 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %v$281, ptr %v$285
   %v$286 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %v$282, ptr %v$286
   
   
   %v$287 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$288 = load i32, i32* %v$287
   %v$289 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$290 = load i32, i32* %v$289
   %v$291 = call i32 @add(i32 %v$288, i32 %v$290)
   
   ret i32 %v$291
}
define i32 @pipeline$19() 
{
   %v$292 = add i32 1, 0
   %v$293 = call i32 @pipeline$18()
   %v$294 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$294 to %$$Int$Int$$*
   %v$296 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %v$292, ptr %v$296
   %v$297 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %v$293, ptr %v$297
   
   
   %v$298 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$299 = load i32, i32* %v$298
   %v$300 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$301 = load i32, i32* %v$300
   %pipelineVar$1 = call i32 @add(i32 %v$299, i32 %v$301)
   
   
   %v$303 = call i32 @print(i32 %pipelineVar$1)
   
   ret i32 %v$303
}
define i32 @pipeline$20(i32 %x) 
{
   %v$304 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$304 to %$$Int$Int$$*
   %v$306 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %x, ptr %v$306
   %v$307 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %x, ptr %v$307
   
   
   %v$308 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$309 = load i32, i32* %v$308
   %v$310 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$311 = load i32, i32* %v$310
   %v$312 = call i32 @add(i32 %v$309, i32 %v$311)
   
   ret i32 %v$312
}
define i32 @pipeline$21(i32 %x) 
{
   %v$313 = call i32 @pipeline$20(i32 %x)
   %v$314 = call i8* @malloc(i32 8)
   %pipelineVar$3 = bitcast i8* %v$314 to %$$Int$Int$$*
   %v$316 = getelementptr %$$Int$Int$$, ptr %pipelineVar$3, i32 0, i32 0
   store i32 %x, ptr %v$316
   %v$317 = getelementptr %$$Int$Int$$, ptr %pipelineVar$3, i32 0, i32 1
   store i32 %v$313, ptr %v$317
   
   
   %v$318 = getelementptr %$$Int$Int$$, ptr %pipelineVar$3, i32 0, i32 0
   %v$319 = load i32, i32* %v$318
   %v$320 = getelementptr %$$Int$Int$$, ptr %pipelineVar$3, i32 0, i32 1
   %v$321 = load i32, i32* %v$320
   %pipelineVar$4 = call i32 @add(i32 %v$319, i32 %v$321)
   
   
   %v$323 = call i32 @print(i32 %pipelineVar$4)
   
   ret i32 %v$323
}
define i32 @pipeline$22(i32 %foo$bar, i32 %foo$baz) 
{
   %v$324 = call i8* @malloc(i32 8)
   %pipelineVar$0 = bitcast i8* %v$324 to %$$Int$Int$$*
   %v$326 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   store i32 %foo$bar, ptr %v$326
   %v$327 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   store i32 %foo$baz, ptr %v$327
   
   
   %v$328 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 0
   %v$329 = load i32, i32* %v$328
   %v$330 = getelementptr %$$Int$Int$$, ptr %pipelineVar$0, i32 0, i32 1
   %v$331 = load i32, i32* %v$330
   %v$332 = call i32 @add(i32 %v$329, i32 %v$331)
   
   ret i32 %v$332
}
define i32 @pipeline$23(%Foo %foo, i32 %foo$bar, i32 %foo$baz) 
{
   %v$333 = call i32 @pipeline$22(i32 %foo$bar, i32 %foo$baz)
   %v$334 = call i8* @malloc(i32 12)
   %pipelineVar$6 = bitcast i8* %v$334 to %$$Foo$Int$$*
   %v$336 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$6, i32 0, i32 0
   %v$337 = bitcast ptr %v$336 to i8*
   %v$338 = bitcast ptr %foo to i8*
      call void @llvm.memcpy.p0.p0.i32(ptr %v$337, ptr %v$338, i32 8, i1 0)
   
   
   
   %v$339 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$6, i32 0, i32 0
   %v$340 = load %Foo, %Foo* %v$339
   %v$341 = getelementptr %$$Foo$Int$$, ptr %pipelineVar$6, i32 0, i32 1
   %v$342 = load i32, i32* %v$341
   %pipelineVar$7 = call i32 @combine(%Foo %v$340, i32 %v$342)
   
   
   %v$344 = call i32 @print(i32 %pipelineVar$7)
   
   ret i32 %v$344
}
declare void @llvm.memcpy.p0.p0.i32(ptr noalias nocapture writeonly, ptr noalias nocapture readonly, i32, i1 immarg) #2
declare i8* @malloc(i32) nounwind
@.str = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1
declare i32 @printf(ptr noundef, ...) #2
