let rec binary_search lst left right ppl =
    if Int64.compare left right >= 0 then left else
        let mid = Int64.div (Int64.add left right) 2L in
        let how_many = List.fold_left (fun acc x -> Int64.add acc (Int64.div mid (Int64.of_int x))) 0L lst in
        if Int64.compare how_many ppl >= 0 then binary_search lst left mid ppl
        else binary_search lst (Int64.add mid 1L) right ppl

let get_input () = Scanf.scanf " %d" (fun x -> x)

let rec input_helper num =
  if num <= 0 then []
  else get_input () :: input_helper (num - 1)

let () =
  let count = get_input () in
  let ppl = Int64.of_int (get_input ()) in
  let arr = input_helper count in
  let max_val = List.fold_left (fun acc x -> if acc > x then acc else x) 0 arr in
  let result = binary_search arr 1L (Int64.mul ppl (Int64.of_int max_val)) ppl in
  Printf.printf "%Ld" result;
