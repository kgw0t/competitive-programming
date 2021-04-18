package main

import (
	"fmt"
)

func main() {
	var H, N int
	fmt.Scan(&H, &N)

	for i := 0; i < N; i++ {
		var A int
		fmt.Scan(&A)

		H -= A
		if H <= 0 {
			fmt.Println("Yes")
			return
		}
	}
	fmt.Println("No")
}
