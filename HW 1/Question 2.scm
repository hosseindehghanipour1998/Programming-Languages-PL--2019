(display 'Welcome!)
(newline)
(display 'Hossein_Dehghanipour_9532250)
(newline)

; Question 2

(define (dot v1 v2 res )
	(if (null?  v1) res
        (dot  (cdr v1) (cdr v2) ( + res ( * (car v1) (car v2 ) ) ) 
		
		)
    )
)
;(display (dot '(  1 2 3 4 ) '( 5 6 7 8 ) 0 ) )

(define (column1 mat )
	
	(cond 
		((null? mat ) () )
		(else 
			( cons ( caar mat ) ( column1 (cdr mat ) ) )
		)
	)

)

( define (vectorMultiply v mat)
	(cond 
		( (null? (car mat)) () )
		(else 
			(cons (dot v (column1 mat) 0 ) ( vectorMultiply v (map cdr mat ) ) )
		)
	)
)

;(display ( vectorMultiply '( 1 2 3 ) '( ( 1 2 3 ) ( 4 5 6) ( 7 8 9 ) ) ) )


(define (matrix_matrix_multiply mat1 mat2 )
	(cond 
		( (null? mat1 ) () )
		(else 
			
			(cons ( vectorMultiply (car mat1) mat2 ) ( matrix_matrix_multiply (cdr mat1) mat2 ) )
		
		)
	
	)
)
(define (main)
	(display 'Answer:)
	(newline)
	;(display (matrix_matrix_multiply '( ( 1 2 )) '( (4 5 6) ( 7 8 9)) ))
	(display (matrix_matrix_multiply '( ( 1 2 3 ) ( 3 4 5) (6 7 8) ) '( (4 5 6) ( 7 8 9)  ( 1 2 3) ) )	)
)

(main)







