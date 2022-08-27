<template>
    <div>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Hotel Reservation</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-striped">
						  <thead>
						    <tr>
						      <th>ID</th>
						      <th>Customer</th>
						      <th>Price</th>
							  <th>Mobile Phone</th>
						      <th>Date checkin</th>
						      <th>Date checkout</th>
						      <th>Status</th>
						    </tr>
						  </thead>
						  <tbody>
						    <tr>
						      <th scope="row"> {{ id }}</th>
						      <td> {{ "Golde" }}</td>
						      <td> {{ 123 }}</td>
							  <td>{{"0988902128"}} </td>
							  <td>{{ "date checkin" }} </td>
						      <td>{{ "date checkout" }} </td>
						      <td style="display:flex"> <button type="button" class="btn btn-primary">Confirm</button> <button type="button" class="btn btn-danger">Remove</button> </td>
							</tr>
							<tr>
						      <th scope="row"> {{ id }}</th>
						      <td> {{ "Golde" }}</td>
						      <td> {{ 123 }}</td>
							  <td>{{"0988902128"}} </td>
							  <td>{{ "date checkin" }} </td>
						      <td>{{ "date checkout" }} </td>
						      <td style="display:flex"> <button type="button" class="btn btn-primary">Confirm</button> <button type="button" class="btn btn-danger">Remove</button> </td>
							</tr>
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
    </div>
</template>

<script setup>

</script>