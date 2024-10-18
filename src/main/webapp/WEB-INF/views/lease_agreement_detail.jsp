

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="property_management.app.entities.LeaseAgreemenrt"%>
<%
LeaseAgreement lease = (LeaseAgreement) request.getAttribute("leaseAgreement");
%>
<%@ page import="java.util.Date"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Lease Agreement Details</title>
<link href="${pageContext.request.contextPath}/styles.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<style>
body {
	font-family: 'Georgia', serif;
	background-color: #f0f0f0;
	margin-top: 70px;
}

.lease-agreement-card {
	background-color: #ffffff;
	border: 1px solid #dddddd;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	margin-bottom: 20px;
	padding: 30px;
	display: flex;
	flex-direction: column;
	width: 80%;
	max-width: 800px;
	margin-left: auto;
	margin-right: auto;
	position: relative;
	overflow: hidden;
	border-top: 5px solid #4CAF50; /* Green accent */
	height: 60em;
}

.lease-agreement-title {
	font-size: 28px;
	font-weight: bold;
	margin-bottom: 10px;
	text-align: center;
	color: #333333;
	border-bottom: 2px solid #4CAF50;
	padding-bottom: 5px;
}

.lease-agreement-content {
	line-height: 1.6;
	font-size: 16px;
	color: #555555;
	margin-bottom: 15px;
}

h4 {
	font-size: 20px;
	color: #4CAF50;
	margin-top: 20px;
}
/* Page numbering effect */
.page-number {
	position: absolute;
	top: 10px;
	right: 10px;
	font-size: 14px;
	color: #aaa;
}

.back-button-container {
	width: 80%;
	max-width: 800px;
	margin-left: auto;
	margin-right: auto;
	position: relative;
	text-align: center;
	margin: 20px 0;
}

.back-button {
	margin-right: 80%;
	display: inline-block;
	padding: 10px 20px;
	background-color: #4CAF50;
	color: white;
	text-decoration: none;
	font-size: 16px;
	border-radius: 5px;
	transition: background-color 0.3s;
	position: relative;
}

.back-button:hover {
	background-color: #45a049;
}
</style>
</head>
<body>

	<!-- Constant Navigation Bar -->
	<nav class="navbar">
		<div class="navbar-container">
			<a href="#" class="logo">Property Management</a>
			<ul class="nav-links">
				<li><a href="/TenantHomePage">Home</a></li>
				<li><a href="/properties">Properties</a></li>
				<li><a href="/lease-agreements">Lease Agreements</a></li>
				<li><a href="/user/AboutUs">About Us</a></li>
				<li><a href="/contact">Contact</a></li>
				<li><a href="/user/openLoginPage" class="login-btn">Login</a></li>
			</ul>
		</div>
	</nav>

	<div class="content">
		<!-- Back to Lease Agreements Button -->
		<div class="back-button-container">
			<a href="/lease-agreements" class="back-button">← Back to Lease
				Agreements</a>
		</div>

		<!-- Lease Agreement Details Section -->
		<section class="lease-agreement-details">
			<div class="lease-agreement-card">
				<div class="lease-agreement-title">Lease Agreement</div>
				<div class="page-number">Page 1</div>
				<div class="lease-agreement-content">
					<p>
						This Lease Agreement is made on this <strong><%=new Date()%></strong>
						between the Landlord and the Tenant. The following terms and
						conditions shall apply:
					</p>
					<h4>1. Duration of Lease</h4>
					<p>
						The lease term will commence on <strong><%=lease.getLeaseStartDate()%></strong>
						and will terminate on <strong><%=lease.getLeaseEndDate()%></strong>.
						The lease is for a period of <strong>[X] years/months</strong>.
					</p>
					<h4>2. Rent Payment</h4>
					<p>
						The monthly rent for the premises shall be <strong><%=lease.getRentAmount()%></strong>.
						The Tenant shall pay the rent by the <strong>[Due Date]</strong>
						of each month, through bank transfer or cheque. In case of late
						payment, a late fee of <strong>[Late Fee]</strong> will apply.
					</p>
					<h4>3. Security Deposit</h4>
					<p>
						The Tenant shall pay a security deposit of <strong><%=lease.getDepositAmount()%></strong>
						prior to moving into the premises. The deposit will be refunded at
						the end of the lease, subject to the condition of the property.
					</p>
					<h4>4. Maintenance and Repairs</h4>
					<p>The Tenant shall keep the premises in good condition and
						shall notify the Landlord of any necessary repairs. The Landlord
						will be responsible for major repairs unless caused by Tenant's
						negligence.</p>
					<h4>5. Termination</h4>
					<p>
						Either party may terminate this lease by providing a written
						notice of <strong>[Notice Period]</strong> days to the other
						party. If the Tenant fails to vacate the premises upon
						termination, the Landlord may pursue legal action.
					</p>

					<!-- Signatures Section -->
					<div class="signatures">
						<p class="landlord-signature">
							__________________________<br>Landlord Signature
						</p>

						<p class="tenant-signature">
							__________________________<br>Tenant Signature
						</p>
					</div>

				</div>
			</div>

			<div class="lease-agreement-card">
				<div class="lease-agreement-title">Lease Agreement</div>
				<div class="page-number">Page 2</div>
				<div class="lease-agreement-content">
					<h4>6. Alterations</h4>
					<p>The Tenant shall not make any alterations to the property
						without prior written consent from the Landlord. Any unauthorized
						alterations may result in deductions from the security deposit.</p>
					<h4>7. Use of Premises</h4>
					<p>The premises shall be used solely for residential purposes.
						Any commercial use is strictly prohibited unless agreed upon in
						writing.</p>
					<h4>8. Pets</h4>
					<p>No pets shall be allowed on the premises without the written
						consent of the Landlord. If pets are allowed, the Tenant must
						comply with any additional terms set forth by the Landlord.</p>
					<h4>9. Governing Law</h4>
					<p>
						This Lease Agreement shall be governed by the laws of the state of
						<strong>[State]</strong>. Any disputes arising from this agreement
						shall be resolved in the courts of <strong>[Location]</strong>.
					</p>

					<!-- Signatures Section -->
					<div class="signatures">
						<p class="landlord-signature">
							__________________________<br>Landlord Signature
						</p>

						<p class="tenant-signature">
							__________________________<br>Tenant Signature
						</p>
					</div>

				</div>
			</div>

			<div class="lease-agreement-card">
				<div class="lease-agreement-title">Lease Agreement</div>
				<div class="page-number">Page 3</div>
				<div class="lease-agreement-content">
					<h4>10. Indemnification</h4>
					<p>The Tenant agrees to indemnify and hold the Landlord
						harmless from any claims, damages, or liabilities arising from the
						Tenant's use of the property.</p>
					<h4>11. Subleasing</h4>
					<p>The Tenant shall not sublease the premises or assign this
						lease without the prior written consent of the Landlord.</p>
					<h4>12. Entry by Landlord</h4>
					<p>The Landlord reserves the right to enter the premises for
						inspections, repairs, or emergencies with reasonable notice to the
						Tenant.</p>
					<h4>13. Entire Agreement</h4>
					<p>This document constitutes the entire agreement between the
						parties and supersedes any prior agreements or understandings.</p>

					<!-- Signatures Section -->
					<div class="signatures">
						<p class="landlord-signature">
							__________________________<br>Landlord Signature
						</p>

						<p class="tenant-signature">
							__________________________<br>Tenant Signature
						</p>
					</div>

				</div>
			</div>

			<div class="lease-agreement-card">
				<div class="lease-agreement-title">Lease Agreement</div>
				<div class="page-number">Page 4</div>
				<div class="lease-agreement-content">
					<h4>14. Amendments</h4>
					<p>Any amendments to this agreement must be made in writing and
						signed by both parties.</p>
					<h4>15. Notices</h4>
					<p>Any notices required or permitted under this agreement shall
						be in writing and delivered to the addresses specified herein.</p>
					<h4>16. Waiver</h4>
					<p>The failure of either party to enforce any provision of this
						agreement shall not be construed as a waiver of that party's right
						to enforce any subsequent breach or default.</p>
					<h4>17. Signatures</h4>
					<p>This agreement shall be signed by both parties as evidence
						of their agreement to the terms and conditions herein.</p>

					<!-- Signatures Section -->
					<div class="signatures">
						<p class="landlord-signature">
							__________________________<br>Landlord Signature
						</p>

						<p class="tenant-signature">
							__________________________<br>Tenant Signature
						</p>
					</div>

				</div>
			</div>

			<div class="lease-agreement-card">
				<div class="lease-agreement-title">Lease Agreement</div>
				<div class="page-number">Page 5</div>
				<div class="lease-agreement-content">
					<p>This Lease Agreement has been prepared with the intent to
						protect both the Landlord and the Tenant. It is advised that both
						parties seek legal counsel to review the terms and conditions
						outlined in this document to ensure clarity and understanding.</p>

					<p>In witness where of, the parties have executed this Lease
						Agreement as of the date first above written.</p>

					<br> <br> <br> <br>
					<!-- Signatures Section -->
					<div class="signatures">
						<p class="landlord-signature">
							__________________________<br>Landlord Signature
						</p>

						<p class="tenant-signature">
							__________________________<br>Tenant Signature
						</p>
					</div>

				</div>
			</div>
		</section>
	</div>

	<!-- Footer Section -->
	<footer class="footer">
		<div class="footer-content">
			<div class="footer-left">
				<h3>Property Management</h3>
				<p>Your one-stop solution for managing and finding properties.</p>
			</div>
			<div class="footer-right">
				<ul class="social-icons">
					<li><a href="#"><i class="fab fa-facebook"></i></a></li>
					<li><a href="#"><i class="fab fa-twitter"></i></a></li>
					<li><a href="#"><i class="fab fa-instagram"></i></a></li>
					<li><a href="#"><i class="fab fa-linkedin"></i></a></li>
				</ul>
			</div>
		</div>
		<div class="footer-bottom">
			<p>&copy; 2024 Property Management System. All Rights Reserved.</p>
		</div>
	</footer>

</body>
</html>
