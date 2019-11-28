(display 'Welcome!)
(newline)
(define (calculateRow x )
	(cond 
		( (null? x ) 0 )
		(else
			( + ( car x ) ( calculateRow (cdr x ) ) )
		)
	)
)

(define (rowSum x)
		(cond 
			( (null? x ) () )
			(else 
				(cons (calculateRow (car x)) (rowSum(cdr x )) )
			)
		)
)

	

(display (rowSum '( (0 1 2 3 4) (5 6 7 8 9) (0 1 2 3 4) (5 6 7 8 9) ) ) )