;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; HW 1 - 3
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(define (rowSum mat)
	(if (null? mat)
		'()
		(cons (eval (cons '+ (car mat))) (rowSum (cdr mat)))
	)
)

(define (colSum mat)
	(if (null? (car mat))
		'()
		(cons (eval (cons '+ (map car mat))) (colSum (map cdr mat)))
	)
)

(display (rowSum '((0 1 2 3 4)(5 6 7 8 9)(0 1 2 3 4)(5 6 7 8 9)))) ;=> (10 35 10 35)
(display "\n")
(display (colSum '((0 1 2 3 4)(5 6 7 8 9)(0 1 2 3 4)(5 6 7 8 9)))) ;=> (10 14 18 22 26)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; HW 1 - 2
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (mul_row_by_row row1 row2)
	(if (null? row1) 
		0
		(+ (* (car row1) (car row2)) (mul_row_by_row (cdr row1) (cdr row2)))
	)
)

(define (mul_row_by_mat row mat)
	(if (null? (car mat)) 
		'() 
		(cons (mul_row_by_row row (map car mat)) (mul_row_by_mat row (map cdr mat)))
	)	
)

(define (mul mat1 mat2)
	(if (null? mat1) 
		'() 
		(cons (mul_row_by_mat (car mat1) mat2) (mul (cdr mat1) mat2))
	)		
)

(display (mul '((1 2 3) (3 2 1)) '((1 -2 -1) (3 1 2) (-1 1 1))))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; HW 1 - 1
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(define (sum list) 
	(cond 
		((eq? (car list) 'leaf)	(cadr list))
		(else (+ (sum (cadr list)) (sum (caddr list))))
	)
 )

(display (sum '(node (leaf 1) (node (leaf 2) (leaf 3)))))