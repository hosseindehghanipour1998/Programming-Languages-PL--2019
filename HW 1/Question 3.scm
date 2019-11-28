(display 'Welcome!)
(newline)
(display 'Hossein_Dehghanipour_9532250)
(newline)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; QUESTION 3 - PART I
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; QUESTION 3 - PART II
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (calculateColumn x )

	(cond 
		( (null? x ) 0 )
		(else
			( + ( caar x) ( calculateColumn ( cdr x ) ) )
		)
	)
)	

(define (colSum x)
	
	(cond 
		( (null?  (car x )) () )
		(else   
			( cons ( calculateColumn x ) ( colSum (map cdr x ) )  )
			
		)
	)
)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; QUESTION 3 - MAIN
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(define (main)
	;;;;;;;;;;;;;;; Call Part I ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	(display 'Part_I_Answer:)
	(newline)
	(display (rowSum '( (0 1 2 3 4) (5 6 7 8 9) (0 1 2 3 4) (5 6 7 8 9) ) ) )
	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	;;;;;;;;;;;;;;; Call Part II ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	(newline)
	(display 'Part_II_Answer:)
	(newline)
	(display (colSum '((0 1 2 3 4) (5 6 7 8 9) (0 1 2 3 4) (5 6 7 8 9))) )

	;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
	0 ; return 0 ( as we do in C )
)

(main)

